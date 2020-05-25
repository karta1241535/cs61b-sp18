public class NBody
{
	public static double readRadius(String filename) {
	    In in = new In(filename);
		int num = in.readInt();
		double Radius = in.readDouble();
		return Radius;
    }

    public static Body[] readBodies(String filename) {
	    In in = new In(filename);
		int num = in.readInt();
		double Second = in.readDouble();
		Body[] Planet = new Body[num];
		int i = 0;
		while (i < num) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			Planet[i] = new Body(xP, yP, xV, yV, m, img);
			i = i + 1; 
		}
		return Planet;
    }

    public static void main(String[] args) {
    	/** Get data */
    	double T = Double.parseDouble(args[0]);
    	double dt = Double.parseDouble(args[1]);
    	String filename = args[2];
    	double Radius = readRadius(filename);
    	Body[] Planet = readBodies(filename);

        /** Draw the background */
    	StdDraw.setScale(-Radius, Radius);
    	StdDraw.clear();
    	StdDraw.picture(0, 0, "images/starfield.jpg");

    	/** Draw the Bodys */
    	for (Body P : Planet) {
    		P.draw();
    	}

    	/** Animation */
    	StdDraw.enableDoubleBuffering();
    	double time = 0;
    	while (time < T) {
    		double[] xForces = new double[Planet.length];
    		double[] yForces = new double[Planet.length];

    		/** Calculate forces */
    		for (int i = 0; i < Planet.length; i++) {
    		    xForces[i] = Planet[i].calcNetForceExertedByX(Planet);
    		    yForces[i] = Planet[i].calcNetForceExertedByY(Planet);
    	    }

    	    /** Update forces */
    		for (int i = 0; i < Planet.length; i++) {
    		    Planet[i].update(dt, xForces[i], yForces[i]);
    	    }

    	    /** Draw the background */
    		StdDraw.setScale(-Radius, Radius);
    	    StdDraw.clear();
    	    StdDraw.picture(0, 0, "images/starfield.jpg");

    	    /** Draw the Bodys */
    	    for (Body P : Planet) {
    		    P.draw();
    	    }

    	    StdDraw.show();
    	    StdDraw.pause(10);
    	    time = time + dt;   
        }

        /** Print universe */
        StdOut.printf("%d\n", Planet.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < Planet.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            Planet[i].xxPos, Planet[i].yyPos, Planet[i].xxVel,
            Planet[i].yyVel, Planet[i].mass, Planet[i].imgFileName);
        }
    } 
}
