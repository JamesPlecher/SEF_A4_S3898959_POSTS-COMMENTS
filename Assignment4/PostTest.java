import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PostTest {

    //Testing length of title
    @Test
    void postTestScenario1(){
        //TestCase1: Length 9. Return false
        Post postTestScenraio1TC1 = new Post( "abcdefghi", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        assertEquals(false, postTestScenraio1TC1.addPost());

        //TestCase2: Length 10. Return true
        Post postTestScenraio1TC2 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        assertEquals(true, postTestScenraio1TC2.addPost());

        //TestCase3: Length 250. Return true
        Post postTestScenraio1TC3 = new Post( "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Aj hssuqhsiqh siqhsiqhsiusssssddqdwqqdqdq dqwd q dqw dqwd qw dqwd qwwd qds", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        assertEquals(true, postTestScenraio1TC3.addPost());

        //TestCase 4: Length 251. Return false
        Post postTestScenraio1TC4 = new Post( "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta. Mauris massai.", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        assertEquals(false, postTestScenraio1TC4.addPost());
    }

    //Testing is special character/number in first 5 characters
    @Test 
    void postTestScenario2(){
        //Number in first 5 characters. Return false
        Post postTestScenraio2TC1 = new Post( "ab1cdefghijk", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        assertEquals(false, postTestScenraio2TC1.addPost());

        //NUmber in 6th character spot. Return true
        Post postTestScenraio2TC2 = new Post( "abcde1fghijk", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        assertEquals(true, postTestScenraio2TC2.addPost());

        //Special character in first 5. Return false
        Post postTestScenraio2TC3 = new Post( "abcd!fghijk", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        assertEquals(false, postTestScenraio2TC3.addPost());

        //Special character in 6th spot. Return true
        Post postTestScenraio2TC4 = new Post( "abcde!fghijk", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        assertEquals(true, postTestScenraio2TC4.addPost());
    }   

    //Testing on easy posts, must have either 2 or 3 tags. 
    @Test
    void postTestScenario3(){
        //One tag. Return false
        Post postTestScenraio3TC1 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1"}, "Easy", "Ordinary");
        assertEquals(false, postTestScenraio3TC1.addPost());
        
        //Two tags. Return true
        Post postTestScenraio3TC2 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2"}, "Easy", "Ordinary");
        assertEquals(true, postTestScenraio3TC2.addPost());

        //Three tags. Return true
        Post postTestScenraio3TC3 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        assertEquals(true, postTestScenraio3TC3.addPost());

        //Four tags, return false
        Post postTestScenraio3TC4 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3", "tag4"}, "Easy", "Ordinary");
        assertEquals(false, postTestScenraio3TC4.addPost());
    }

    //Testing postTypes VD and DI postBody lengths
    @Test
    void postTestScenario4(){
        //VD 300 characters. Return true
        Post postTestScenraio4TC1 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctu", 
        new String[] {"tag1", "tag2", "tag3"}, "Very Difficult", "Immediately Needed");
        assertEquals(true, postTestScenraio4TC1.addPost());

        //VD 299 characters. Return false
        Post postTestScenraio4TC2 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auct", 
        new String[] {"tag1", "tag2", "tag3"}, "Very Difficult", "Immediately Needed");
        assertEquals(false, postTestScenraio4TC2.addPost());

        //DI 300 characters. Return true
        Post postTestScenraio4TC3 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctu", 
        new String[] {"tag1", "tag2", "tag3"}, "Difficult", "Immediately Needed");
        assertEquals(true, postTestScenraio4TC3.addPost());

        //DI 299 characters. Return false
        Post postTestScenraio4TC4 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auct", 
        new String[] {"tag1", "tag2", "tag3"}, "Difficult", "Immediately Needed");
        assertEquals(false, postTestScenraio4TC4.addPost());
    }

    //Testing character tag length
    @Test 
    void postTestScenario5(){
        //One chacter length. Return false
        Post postTestScenraio5TC1 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"a", "tag2"}, "Easy", "Ordinary");
        assertEquals(false, postTestScenraio5TC1.addPost());

        //Two character length. Return true
        Post postTestScenraio5TC2 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"ab", "tag2"}, "Easy", "Ordinary");
        assertEquals(true, postTestScenraio5TC2.addPost());

        Post postTestScenraio5TC3 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"abcdefghij", "tag2"}, "Easy", "Ordinary");
        assertEquals(true, postTestScenraio5TC3.addPost());

        Post postTestScenraio5TC4 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"abcdefghijk", "tag2"}, "Easy", "Ordinary");
        assertEquals(false, postTestScenraio5TC4.addPost());
    }

    //Testing “Difficult” (DI) can have 2 to 5 tags
    @Test 
    void postTestScenario6(){
        //One tag on Difficult. Return false
        Post postTestScenraio6TC1 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctu", 
        new String[] {"tag1"}, "Difficult", "Immediately Needed");
        assertEquals(false, postTestScenraio6TC1.addPost());

        //Two tags on Difficult. Return true
        Post postTestScenraio6TC2 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctu", 
        new String[] {"tag1", "tag2"}, "Difficult", "Immediately Needed");
        assertEquals(true, postTestScenraio6TC2.addPost());

        //Five tags on Difficult. Return true
        Post postTestScenraio6TC3 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctu", 
        new String[] {"tag1", "tag2", "tag3", "tag4", "tag5"}, "Difficult", "Immediately Needed");
        assertEquals(true, postTestScenraio6TC3.addPost());

        //Six tags on Difficult. Return false
        Post postTestScenraio6TC4 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctu", 
        new String[] {"tag1", "tag2", "tag3", "tag4", "tag5", "tag6"}, "Difficult", "Immediately Needed");
        assertEquals(false, postTestScenraio6TC4.addPost());
    }

    //Testing “Very Difficult” (DI) can have 2 to 5 tags
    @Test 
    void postTestScenario7(){
        //One tag on Very Difficult. Return false
        Post postTestScenraio7TC1 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctu", 
        new String[] {"tag1"}, "Very Difficult", "Immediately Needed");
        assertEquals(false, postTestScenraio7TC1.addPost());

        //Two tags on Very Difficult. Return true
        Post postTestScenraio7TC2 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctu", 
        new String[] {"tag1", "tag2"}, "Very Difficult", "Immediately Needed");
        assertEquals(true, postTestScenraio7TC2.addPost());

        //Five tags on Very Difficult. Return true
        Post postTestScenraio7TC3 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctu", 
        new String[] {"tag1", "tag2", "tag3", "tag4", "tag5"}, "Very Difficult", "Immediately Needed");
        assertEquals(true, postTestScenraio7TC3.addPost());

        //Six tags on Very Difficult. Return false
        Post postTestScenraio7TC4 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctu", 
        new String[] {"tag1", "tag2", "tag3", "tag4", "tag5", "tag6"}, "Very Difficult", "Immediately Needed");
        assertEquals(false, postTestScenraio7TC4.addPost());
    }

    //Testing first character of comment is uppercase
    @Test 
    void commentTestScenario1(){
        Post commentTestScenraio1 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        commentTestScenraio1.addPost();
        //TC1: upper case, return true
        assertEquals(true, commentTestScenraio1.addComment("Testing uppercase first word"));
        //TC2: lower case, return false
        assertEquals(false, commentTestScenraio1.addComment("testing uppercase first word"));
    }

    //Testing minimum number of words (4)
    @Test 
    void commentTestScenario2(){
        Post commentTestScenraio2 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        commentTestScenraio2.addPost();
        //TC1: Four words, return true
        assertEquals(true, commentTestScenraio2.addComment("Testing amount of words"));
        //TC2: Three words, return false
        assertEquals(false, commentTestScenraio2.addComment("Testing word amount"));
    }

    //Testing maximum number of words (10)
    @Test 
    void commentTestScenario3(){
        Post commentTestScenraio3 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        commentTestScenraio3.addPost();
        //TC1: ten words, return true
        assertEquals(true, commentTestScenraio3.addComment("One two three four five six seven eight nine ten"));
        //TC2: eleven words, return false
        assertEquals(false, commentTestScenraio3.addComment("One two three four five six seven eight nine ten eleven"));
    }

    //Testing max amount of comments for "Easy" / "Ordinary" posts (3)
    @Test 
    void commentTestScenario4(){
        Post commentTestScenraio4 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Easy", "Ordinary");
        commentTestScenraio4.addPost();
        //TC1: First 3 will be valid and return true
        assertEquals(true, commentTestScenraio4.addComment("This is comment one"));
        assertEquals(true, commentTestScenraio4.addComment("This is comment two"));
        assertEquals(true, commentTestScenraio4.addComment("This is comment three"));
        //TC2: Adding a forth comment, return false
        assertEquals(false, commentTestScenraio4.addComment("This is comment four"));
    }
    
    //Testing max amount of comments for "Difficult" posts (5)
    @Test 
    void commentTestScenario5(){
        Post commentTestScenraio5 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Difficult", "Highly Needed");
        commentTestScenraio5.addPost();
        //TC1: First 5 will be valid and return true
        assertEquals(true, commentTestScenraio5.addComment("This is comment one"));
        assertEquals(true, commentTestScenraio5.addComment("This is comment two"));
        assertEquals(true, commentTestScenraio5.addComment("This is comment three"));
        assertEquals(true, commentTestScenraio5.addComment("This is comment four"));
        assertEquals(true, commentTestScenraio5.addComment("This is comment five"));
        //TC2: Adding a sixth comment, return false
        assertEquals(false, commentTestScenraio5.addComment("This is comment six"));    
    }

    //Testing max amount of comments for "Very Difficult" posts (5)
    @Test 
    void commentTestScenario6(){
        Post commentTestScenraio6 = new Post( "abcdefghij", 
        "Lorem ipsum dolor sit amettttttt, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras vehicula lectus vel risus bibendum, a elementum orci pharetra. Integer et eros ac urna facilisis hendrerit at nec odio. Nullam tincidunt quam et dolor varius, et aliquam sapien auctor", 
        new String[] {"tag1", "tag2", "tag3"}, "Very Difficult", "Highly Needed");
        commentTestScenraio6.addPost();
        //TC1: First 5 will be valid and return true
        assertEquals(true, commentTestScenraio6.addComment("This is comment one"));
        assertEquals(true, commentTestScenraio6.addComment("This is comment two"));
        assertEquals(true, commentTestScenraio6.addComment("This is comment three"));
        assertEquals(true, commentTestScenraio6.addComment("This is comment four"));
        assertEquals(true, commentTestScenraio6.addComment("This is comment five"));
        //TC2: Adding a sixth comment, return false
        assertEquals(false, commentTestScenraio6.addComment("This is comment six"));    
    }


    

}
