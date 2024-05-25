import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Post {
    /*using random to generate a random post id. For the purposes of the assignemnt its not needed but i did this so 
    comments and posts can be linked in the seperate text files :) */
    Random rand = new Random();
    private int postID = rand.nextInt(1000000);
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String postTypes;
    private String postEmergency;
    private ArrayList<String> postComments = new ArrayList<>();

    public Post(String postTitle, String postBody, String[] postTags, String postTypes, String postEmergency) {
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postTags = postTags;
        this.postTypes = postTypes;
        this.postEmergency = postEmergency;
        this.postComments = new ArrayList<>();
    }

    public boolean addPost() {
        boolean valid = true;
        //Title length must be 10 or larger than  and 250 or lower amount of characters. If not false.
        if (postTitle.length() < 10 || postTitle.length() > 250) {
            valid = false;
        }
        //For the first 5 characters in title, check they are all characters. 
        for (int i = 0; i < 5; i++) {
            char c = postTitle.charAt(i);
            if (!Character.isLetter(c)) {
                valid = false;
            }
        }
        //Check The body length is at least 250
        if (postBody.length() < 250) {
            valid = false;
            System.out.println(postBody.length());
        }
        //Check amount of tags is from 2 to 5
        if (postTags.length < 2 || postTags.length > 5) {
            valid = false;
        }
        //for each tag, check it has from 2 to 10 characters
        for (String postTag : postTags) {
            if (postTag.length() < 2 || postTag.length() > 10) {
                valid = false;
            }
            //for the length of current tag, make sure they are all lower case
            for (int j = 0; j < postTag.length(); j++) {
                char c = postTag.charAt(j);
                if (Character.isUpperCase(c)) {
                    valid = false;
                }
            }
        }

        //For postType = "Easy"
        if (postTypes.equals("Easy")) {
            //check if it has less than 3 tags. With the above condition, it has to be either 2 or 3 tags
            if (postTags.length > 3) {
                valid = false;
            }
            //if its an easy post type, has to have ordianry emergecy 
            if (!postEmergency.equals("Ordinary")) {
                valid = false;
            }
        } 
        //For postType = "Very Difficult" or "Difficult"
        else if (postTypes.equals("Difficult") || postTypes.equals("Very Difficult")) {
            //length must be 300 characters or more for the postBody
            if (postBody.length() < 300) {
                valid = false;
            }
            //if postEmergency doesnt equal "Immediately or Highly Needed", fail the post
            if (!postEmergency.equals("Immediately Needed") && !postEmergency.equals("Highly Needed")) {
                valid = false;
            }
        } 
        //if incorrectly set, fail
        else {valid = false;}

        //IF AND ONLY IFF ALL CONDITIONS ABOVE DONT FAIL, add the post info to a post.txt file
        if (valid) {
            //because tags is a String array, this turns it into a string seperated by commas.
            String postTags_txt = String.join(", ", postTags);
            appendToFile("posts.txt", "Post ID: " + postID + "\nPost Title: " + postTitle + "\nPost Body: " + postBody + "\nPost Tags: " + postTags_txt + "\nPost Type: " + postTypes + "\nPost Emergency: " + postEmergency + "\n");
        }

        return valid;
    }

    public boolean addComment(String comment) {
        boolean valid_comment = true;
        //turn the comment into words, determined by white spaces in the comment
        String[] words = comment.split("\\s+");
        //if word count is less than 4 or larger than 10, fail
        if (words.length < 4 || words.length > 10) {
            valid_comment = false;
        }
        //if the first character isnt uppercase, fail
        if (!Character.isUpperCase(comment.charAt(0))) {
            valid_comment = false;
        }
        //If post already has 5 comments, dont add any more
        if (postComments.size() >= 5) {
            valid_comment = false;
        }
        //if post is Easy or Ordainry, dont add more than 3 comments
        if (postTypes.equals("Easy") || postEmergency.equals("Ordinary")) {
            if (postComments.size() >= 3) {
                valid_comment = false;
            }
        }
        //if comment conditions above dont fail, append comment to a comment.txt file with the corresponding post's postID
        if (valid_comment) {
            postComments.add(comment);
            appendToFile("comments.txt", "Post ID: " + postID + "\nComment: " + comment + "\n");
        }

        return valid_comment;
    }
    //just write all the passed content into a txt file
    private void appendToFile(String fileName, String content) {
        /* ***********************************************************IMPORTANT************************************************************************ */
        //The posts.txt and comments.txt will be created and saved to where ever you currently are in the directory. To view them either go to that 
        //directory or change the directory in the terminal to a more desirable location. Or use a better method of ur own thats just my quick suggestion. 
        // Hope it helps :)
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(content);
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Post post = new Post("abcdefghij",
            "LOOOOOO ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor",
            new String[] { "tag1", "tag2", "tag3" }, "Easy", "Ordinary");
        post.addPost();
        // post.addComment("IQHDIUHQIUHQWIUDHQUIWDHQWID");
        // post.addComment("TqwdDQIWDHQIUWHDKQJS xkjqndwjkqwndiqwhd");
        // post.addComment("28u329djqdmiondiqu");
        post.addComment("Awdhu wh du hduw dhu dhduw");
        post.addComment("YOU MAKE DREAMs COME ");
    }
}
