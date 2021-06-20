package test;

public class CorrelatedFeatures {
	public  String feature1,feature2;
	public  float corrlation;
	public  Line lin_reg;
	public  float threshold;

	public CorrelatedFeatures() {
		
	}

	public CorrelatedFeatures(String feature1, String feature2, float corrlation, Line lin_reg, float threshold) {
		this.feature1 = feature1;
		this.feature2 = feature2;
		this.corrlation = corrlation;
		this.lin_reg = lin_reg;
		this.threshold = threshold;
	}
	
}
