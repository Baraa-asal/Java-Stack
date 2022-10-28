import java.util.Date;

public class AlfredQuotes {
    
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return String.format("Hello,%s. Lovely to see you.", name);
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "It is currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        int a = conversation.indexOf("Alexis");
        int b = conversation.indexOf("Alfred");
        if (a > -1) {
            return "Right away, sir. She cartainly isn't sophisticated enough for that.";
        }
        else if (b > -1) {
            return "At your service. As you wish, naturally.";
        }
        return "Right. And with that I shall retire";
    }

}

