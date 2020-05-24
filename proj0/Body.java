import java.lang.Math;

public class Body {
	public double xxPos;

	public double yyPos;

	public double xxVel;

	public double yyVel;

	public double mass;

	public String imgFileName;

	private static final double G = 6.67e-11;

	public Body(double xP, double yP, double xV,
	            double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b) {
    	double xDist = b.xxPos - this.xxPos;
    	double yDist = b.yyPos - this.yyPos;
    	double r2Dist = xDist * xDist + yDist * yDist;
    	double rDist = Math.sqrt(r2Dist);
    	return rDist;
    }

    public double calcForceExertedBy(Body b) {
    	double R = calcDistance(b);
    	double F = G * this.mass * b.mass / R / R;
    	return F;
    }

    public double calcForceExertedByX(Body b) {
    	double F = calcForceExertedBy(b);
    	double xDist = b.xxPos - this.xxPos;
    	double R = calcDistance(b);
    	double Fx = F * xDist / R;
    	return Fx;
    }

    public double calcForceExertedByY(Body b) {
    	double F = calcForceExertedBy(b);
    	double yDist = b.yyPos - this.yyPos;
    	double R = calcDistance(b);
    	double Fy = F * yDist / R;
    	return Fy;
    }

    public double calcNetForceExertedByX(Body[] b) {
    	double Fnetx = 0;
    	for (int i = 0; i < b.length; i++) {
    		if (this.equals(b[i]) == true) {
    			continue;
    		}
    		Fnetx = Fnetx + calcForceExertedByX(b[i]);
    	}
    	return Fnetx;
    }

    public double calcNetForceExertedByY(Body[] b) {
    	double Fnety = 0;
    	for (int i = 0; i < b.length; i++) {
    		if(this.equals(b[i]) == true) {
    			continue;
    		}
    		Fnety = Fnety + calcForceExertedByY(b[i]);
    	}
    	return Fnety;
    }

    public void update(double dt, double fX, double fY) {
    	double ax = fX / this.mass;
    	double ay = fY / this.mass;
    	this.xxVel = this.xxVel + ax * dt;
        this.yyVel = this.yyVel + ay * dt;
        this.xxPos = this.xxPos + xxVel * dt;
        this.yyPos = this.yyPos + yyVel * dt;
    }

    public void draw() {
    	StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}

