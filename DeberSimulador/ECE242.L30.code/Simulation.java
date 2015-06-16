import java.util.Random;


public class Simulation {
	public Random generator = new Random(); // random number generator
	public EventHeap h;
	double now;
	
	public Machine m = new Machine();
	public Repairman r = new Repairman();
	public User u = new User();
	public WriteFile w = new WriteFile(); // variable para escribir el archivo     
        public Integer tiempo = 0;
        
	public Simulation() {
		generator = new Random();
		h = new EventHeap(10000);
		now = 0;                
	}

	public void scheduleEvent(Event e) {
		h.insert(e);
	}
	
	public void setup() {
		Event machineEvent = new Event();
		machineEvent.setHandler(m);
		machineEvent.setType(working);
		machineEvent.setTime(0);
		scheduleEvent(machineEvent);
		
		Event userEvent = new Event();
		userEvent.setHandler(u);
		userEvent.setType(userCheck);
		userEvent.setTime(60);
		scheduleEvent(userEvent);
		return;
	}
	
        public Integer nextIndex(){
            if(tiempo > r.lector.tiempos.size()){
                this.tiempo =0;
            }
            return this.tiempo;
       
        }
        
	public void run(double maxTime) {
		while (!h.isEmpty() && h.peek().getTime()<=maxTime) {
                    tiempo=this.nextIndex();
                    Event nextEvent = h.remove();
                    now = nextEvent.getTime();
                    nextEvent.getHandler().respondToEvent(nextEvent, this,w, tiempo);
                    tiempo = tiempo + 1;
		}
                w.escribirArchivo();                                
                //System.out.println(m.lector.readFileTime(w.archivo.getName(), "finishing repair", "machine failure"));                   
	}
	// events
	public final int working = 1;
	public final int failure = 2;
	public final int startRepair = 3;
	public final int finishRepair = 4;
	public final int userCheck = 5;

}
