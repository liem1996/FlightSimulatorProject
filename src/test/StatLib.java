package test;

public class StatLib {

	// simple average
	public static float avg(float[] x)
	{
		float sum=0;
		float avg=0;

		for(int i=0;i<x.length;i++)
		{
			sum+=x[i];
		}

		avg=sum/x.length;
		return avg;
	}

	// returns the variance of X and Y
	public static float var(float[] x){

		/*
		float[] newX=new float[x.length];
		float a=0;
		float var1;
		float avg= avg(x);
		for(int i=0;i<x.length;i++) {
			newX[i] = x[i] * x[i];
			a=a+newX[i];
		}
		var1=(a/x.length)-(avg*avg);
		return var1;

		 */

			float av=avg(x);
			float sum=0;
			for(int i=0;i<x.length;i++){
				sum+=x[i]*x[i];
			}

			return sum/x.length - av*av;







	}
	// returns the covariance of X and Y
	public static float cov(float[] x, float[] y)
	{
		float cov = 0;
		float avgX=avg(x);
		float avgY=avg(y);

		if(x.length==0&&y.length==0)
		{
			return 0;
		}

		for(int i=0;i<x.length;i++)
		{
			cov+=(x[i]-avgX)*(y[i]-avgY);

		}
		return cov/x.length;



	}
	// returns the Pearson correlation coefficient of X and Y
	public static float pearson(float[] x, float[] y)
	{

		float person1=cov(x,y);
		float StandardDevY=(float)Math.sqrt(var(y));
		float StandardDevX=(float)Math.sqrt(var(x));

		float personNew=person1/(StandardDevX*StandardDevY);
		return personNew;
	}
	// performs a linear regression and returns the line equation
	public static test.Line linear_reg(test.Point[] points) {
		test.Line rgrasiv;
		float[]  xs= new float [points.length];
		float[] ys= new float [points.length];
		float a=0;
		float b;
		for(int i=0;i<points.length;i++)
		{
			xs[i]=points[i].x;
			ys[i]=points[i].y;

		}
		a=cov(xs,ys)/var(xs);




		b=avg(ys)-a*avg(xs);

		rgrasiv=new test.Line(a,b);

		return rgrasiv;



	};
	// returns the deviation between point p and the line equation of the points
	public static float dev(test.Point p, test.Point[] points) {

		test.Line dev1=linear_reg(points);
		float res=dev1.f(p.x);
		if(res-p.y<0)
		{
			return -1*(res-p.y);
		}
		return res-p.y;




	};
	// returns the deviation between point p and the line
	public static float dev(test.Point p, test.Line l) {

		float res=l.f(p.x);

		if(res-p.y<0)
		{
			return -1*(res-p.y);
		}
		return res-p.y;

	};

}
