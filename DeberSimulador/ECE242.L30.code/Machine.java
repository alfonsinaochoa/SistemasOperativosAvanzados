
public class Machine implements EventHandler {
	private double MTTF;
	private double MTTFvariance;
	public boolean working;
        public ReadFile lector; // variable para leer el archivo
	
	public Machine() {
		MTTF = 30.0;
		MTTFvariance = 5.0;
		working = true;
                lector = new ReadFile("traces2.txt");
	}
	
	@Override
	public void respondToEvent(Event e, Simulation s, WriteFile w, Integer tiempo) {
            String cadena;
		if (e.getType()==s.working) {
                        cadena = e.getTime()+":machine working";
			System.out.println(cadena);                        
                        w.llenarArreglo(cadena);			
			working=true;
                        double timeToNextFailure = lector.tiempos.get(tiempo);
			//double timeToNextFailure = Math.abs(s.generator.nextGaussian()*MTTFvariance+MTTF);
			//e.setTime(s.now+timeToNextFailure);
                        e.setTime(timeToNextFailure);
			e.setType(s.failure);
			s.scheduleEvent(e);
			return;
		}
		if (e.getType()==s.failure) {
			cadena = e.getTime()+":machine failure";
			System.out.println(cadena);                        
                        w.llenarArreglo(cadena);
			working=false;
			e.setTime(s.now);
			e.setHandler(s.r);
			e.setType(s.startRepair);
			s.scheduleEvent(e);
			return;
		}

	}

}
