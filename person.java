public class person {

    String name;
    String surName;
    String email;

    person(String name,String surName ,String email){
        this.name=name;
        this.surName=surName;
        this.email=email;

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurName() {

        return surName;
    }

    public void setSurName(String surName) {

        this.surName = surName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void printInfo(){
        System.out.println("Name:"+this.name);
        System.out.println("Surname:"+this.surName);
        System.out.println("Email:"+this.email);

    }
}