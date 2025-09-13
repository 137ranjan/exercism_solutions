class Badge {
    public String print(Integer id, String name, String department) {
        if(id == null && department == null){
            return name+" - OWNER";
        }else if(id != null && department == null){
            return "["+id+"] - "+name+" - OWNER";
        }else if(id == null && department != null){
            return name+" - "+department.toUpperCase();
        }else{
            return "["+id+"] - "+name+" - "+department.toUpperCase();
        }
        //throw new UnsupportedOperationException("Please implement the Badge.print() method");
    }
}
