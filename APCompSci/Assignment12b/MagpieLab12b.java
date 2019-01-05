import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class MagpieLab12b
{
   
   ArrayList<String> familyResponse = new ArrayList<String>();
	
   public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
        
      
		else if (statement.indexOf("mother")  >= 0
				|| statement.indexOf("father")  >= 0
				|| statement.indexOf("sister")  >= 0
				|| statement.indexOf("brother") >= 0
            || statement.indexOf("family")  >= 0
            || statement.indexOf("parent")  >= 0)
		{ 
      
         response =  getRandomFamilyResponse();
       
      
        
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}
   `
   private String getRandomFamilyResponse()
   {
         String answer ="";
        
         
         familyResponse.add("Tell me about your parents");
         familyResponse.add("Tell me about your siblings");
         familyResponse.add("How are your grandparents");
         familyResponse.add("Where do they live");
         familyResponse.add("Where were they born");
         familyResponse.add("What country are they from?");
         familyResponse.add("Tell me more about your family");
         familyResponse.add("How did your parents meet?");
         familyResponse.add("How did your grandparents meet?");
         familyResponse.add("How old are your siblings?");
        
         
         Random rand = new Random(); 
         int value = rand.nextInt(10); 
         
         answer = familyResponse.get(value);
         
         return answer;
         
   }

	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 10;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
      else if (whichResponse ==4)
      {
         response = "Who do you think will win the SuperBowl?";
      
      }
      else if (whichResponse ==5)
      {
         response = "What is your favourite movie?";
      }
      else if (whichResponse == 6)
      {
         response = "What's your favourite colour?";
      }
      else if (whichResponse == 7)
      {
       response = "I like pickles";
      }
      else if (whichResponse== 8)
      {
         response = "What is your favourite holiday?";
      }
      else if (whichResponse == 9)
      {
         response = "When's your birthday?";
      }
      else if (whichResponse == 10)
      {
         response = "What's your favourite food?";
      }
      
      
		return response;
	}
}
