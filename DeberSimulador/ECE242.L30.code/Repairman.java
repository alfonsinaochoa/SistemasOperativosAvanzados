
public class Repairman implements EventHandler {

	double MTTR;
	double MTTRvariance;
        public ReadFile lector; // variable para leer el archivo
	
	public Repairman() {
		MTTR = 10.0;
		MTTRvariance = 2.0;
                lector = new ReadFile("traces.txt");
	}
	
	
	@Override
	public void respondToEvent(Event e, Simulation s, WriteFile w, Integer tiempo) {
            String cadena;
		if (e.getType()==s.startRepair) {
                        cadena = e.getTime()+":starting repair";                        
			System.out.println(cadena);                        
                        w.llenarArreglo(cadena);     
                        double timeToRepair = lector.tiempos.get(tiempo);                        
			//double timeToRepair = Math.abs(s.generator.nextGaussian()*MTTRvariance+MTTR);
			e.setType(s.finishRepair);
			e.setTime(s.now+timeToRepair);
			s.scheduleEvent(e);
			return;
		}
		if (e.getType()==s.finishRepair) {
                        cadena = e.getTime()+":finishing repair";
			System.out.println(cadena);                        
                        w.llenarArreglo(cadena);			
			e.setHandler(s.m);
			e.setType(s.working);
			e.setTime(s.now);
			s.scheduleEvent(e);
			return;
		}
	}

}
