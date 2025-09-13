import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
        GrepFlags grepFlags = GrepFlags.from(flags);
        List<String> results = new ArrayList<>();
        for (String fileName : files) {
            List<String> lines;
            try {
                lines = Files.readAllLines(Paths.get(fileName));
            } catch (IOException e) {
                throw new RuntimeException("Could not read file: " + fileName, e);
            }

            boolean fileMatched = false;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                int lineNumber = i + 1;

                if (matches(line, pattern, grepFlags)) {
                    fileMatched = true;
                    if (!grepFlags.listFilesOnly) {
                        StringBuilder sb = new StringBuilder();
                        if (files.size() > 1) {
                            sb.append(fileName).append(":");
                        }
                        if (grepFlags.lineNumbers) {
                            sb.append(lineNumber).append(":");
                        }
                        sb.append(line);
                        results.add(sb.toString());
                    }
                }
            }

            if (grepFlags.listFilesOnly && fileMatched) {
                results.add(fileName);
            }
        }
        return String.join("\n", results);
    }

    private boolean matches(String line, String pattern, GrepFlags flags) {
        String candidate = line;
        String term = pattern;

        if (flags.caseInsensitve) {
            candidate = candidate.toLowerCase();
            term = term.toLowerCase();
        }

        boolean found = flags.matchEntireLine ? candidate.equals(term) : candidate.contains(term);
        return flags.invertMatch ? !found : found;
    }
}