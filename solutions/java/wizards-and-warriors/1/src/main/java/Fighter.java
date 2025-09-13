abstract class Fighter {

    boolean isVulnerable() {
        return false;
    }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends Fighter {

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    int damagePoints(Fighter wizard) {
        return (wizard.isVulnerable())? 10 : 6;
    }
}

class Wizard extends Fighter {

    private boolean isSpellPrepared = false;
    @Override
    boolean isVulnerable() {
        return (isSpellPrepared)? false : true;
    }

    @Override
    int damagePoints(Fighter warrior) {
        return (isSpellPrepared)? 12 : 3;
    }

    void prepareSpell() {
        isSpellPrepared = true;
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

}
