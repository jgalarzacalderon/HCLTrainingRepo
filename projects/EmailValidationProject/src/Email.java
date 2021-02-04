// Creates Email Object to be used in the EmailMain class.
public class Email {

       private String email;
       private String name;
       
       public Email(String emailAdd, String ownName) {
    	   this.email = emailAdd;
    	   this.name = ownName;
       }

       public void setEmail(String newEmail) {
    	   this.email = newEmail;
       }      

       public void setName(String newName) {
    	   this.name = newName;
       }      

       public String getName() {
    	   return name;
       }

       public String getEmail() {
    	   return email;
       }
}       