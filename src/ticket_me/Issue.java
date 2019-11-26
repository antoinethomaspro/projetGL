package ticket_me;

import java.util.ArrayList;
import java.util.List;

public class Issue extends Tickets {
    private List<Tickets> ListTicket;

    public Issue() {
    	 ListTicket = new ArrayList<Tickets>();
    }
    
    public List<Tickets> getList() {
    	return ListTicket;
    }
    
    public void setListTicket(List<Tickets> listTicket) {
		ListTicket = listTicket;
	}
    
  /*Permettre de mettre les tickets ayant le meme type ensemble*/
    public void addTicket(Tickets t) {
    	for(int i = 0; i<ListTicket.size();i++) {
    		ListTicket.add(t);
    	}
    	
    }
    
    public void Close() {
    	
    }

	

	
    
   
}

