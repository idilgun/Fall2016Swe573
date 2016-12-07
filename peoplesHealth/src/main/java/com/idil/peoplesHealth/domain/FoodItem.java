package com.idil.peoplesHealth.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "poeplesHealth.ITEM")
public class FoodItem {
	
	@Embeddable
	public static class ndbno_itemUnit implements Serializable {
		@Column(name="ndbno")
		private String ndbno;

	    @Column(name="itemUnit")
	    private String itemUnit;

		public String getNdbno() {
			return ndbno;
		}

		public void setNdbno(String ndbno) {
			this.ndbno = ndbno;
		}

		public String getItemUnit() {
			return itemUnit;
		}

		public void setItemUnit(String itemUnit) {
			this.itemUnit = itemUnit;
		}
	    
	    
	}
	
	@EmbeddedId
	ndbno_itemUnit ndbno_unit;
	
	@Column(name = "calorie")
	private Double calorie;
	
	@Column(name = "calorieUnit")
	private String calorieUnit;
	
	@Column(name = "protein")
	private Double protein;
	
	@Column(name = "proteinUnit")
	private String proteinUnit;
	
	@Column(name = "water")
	private Double water;
	
	@Column(name = "waterUnit")
	private String waterUnit;
	
	@Column(name = "fat")
	private Double fat;
	
	@Column(name = "fatUnit")
	private String fatUnit;
	
	@Column(name = "carbohydrate")
	private Double carbohydrate;
	
	@Column(name = "carbohydrateUnit")
	private String carbohydrateUnit;
	
	@Column(name = "fiber")
	private Double fiber;
	
	@Column(name = "fiberUnit")
	private String fiberUnit;
	
	@Column(name = "sugars")
	private Double sugars;
	
	@Column(name = "sugarsUnit")
	private String sugarsUnit;
	
	@Column(name = "calcium")
	private Double calcium;
	
	@Column(name = "calciumUnit")
	private String calciumUnit;
	
	@Column(name = "iron")
	private Double iron;
	
	@Column(name = "ironUnit")
	private String ironUnit;
	
	@Column(name = "magnesium")
	private Double magnesium;
	
	@Column(name = "magnesiumUnit")
	private String magnesiumUnit;
	
	@Column(name = "phosphorus")
	private Double phosphorus;
	
	@Column(name = "phosphorusUnit")
	private String phosphorusUnit;
	
	@Column(name = "potassium")
	private Double potassium;
	
	@Column(name = "potassiumUnit")
	private String potassiumUnit;
	
	@Column(name = "sodium")
	private Double sodium;
	
	@Column(name = "sodiumUnit")
	private String sodiumUnit;

	@Column(name = "zinc")
	private Double zinc;
	
	@Column(name = "zincUnit")
	private String zincUnit;
	
	@Column(name = "vitaminC")
	private Double vitaminC;
	
	@Column(name = "vitaminCUnit")
	private String vitaminCUnit;
	
	@Column(name = "cholesterol")
	private Double cholesterol;
	
	@Column(name = "cholesterolUnit")
	private String cholesterolUnit;
	
	@Column(name = "caffeine")
	private Double caffeine;
	
	@Column(name = "caffeineUnit")
	private String caffeineUnit;

	public ndbno_itemUnit getNdbno_unit() {
		return ndbno_unit;
	}

	public void setNdbno_unit(ndbno_itemUnit ndbno_unit) {
		this.ndbno_unit = ndbno_unit;
	}

	public Double getCalorie() {
		return calorie;
	}

	public void setCalorie(Double calorie) {
		this.calorie = calorie;
	}

	public String getCalorieUnit() {
		return calorieUnit;
	}

	public void setCalorieUnit(String calorieUnit) {
		this.calorieUnit = calorieUnit;
	}

	public Double getProtein() {
		return protein;
	}

	public void setProtein(Double protein) {
		this.protein = protein;
	}

	public String getProteinUnit() {
		return proteinUnit;
	}

	public void setProteinUnit(String proteinUnit) {
		this.proteinUnit = proteinUnit;
	}

	public Double getWater() {
		return water;
	}

	public void setWater(Double water) {
		this.water = water;
	}

	public String getWaterUnit() {
		return waterUnit;
	}

	public void setWaterUnit(String waterUnit) {
		this.waterUnit = waterUnit;
	}

	public Double getFat() {
		return fat;
	}

	public void setFat(Double fat) {
		this.fat = fat;
	}

	public String getFatUnit() {
		return fatUnit;
	}

	public void setFatUnit(String fatUnit) {
		this.fatUnit = fatUnit;
	}

	public Double getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(Double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public String getCarbohydrateUnit() {
		return carbohydrateUnit;
	}

	public void setCarbohydrateUnit(String carbohydrateUnit) {
		this.carbohydrateUnit = carbohydrateUnit;
	}

	public Double getFiber() {
		return fiber;
	}

	public void setFiber(Double fiber) {
		this.fiber = fiber;
	}

	public String getFiberUnit() {
		return fiberUnit;
	}

	public void setFiberUnit(String fiberUnit) {
		this.fiberUnit = fiberUnit;
	}

	public Double getSugars() {
		return sugars;
	}

	public void setSugars(Double sugars) {
		this.sugars = sugars;
	}

	public String getSugarsUnit() {
		return sugarsUnit;
	}

	public void setSugarsUnit(String sugarsUnit) {
		this.sugarsUnit = sugarsUnit;
	}

	public Double getCalcium() {
		return calcium;
	}

	public void setCalcium(Double calcium) {
		this.calcium = calcium;
	}

	public String getCalciumUnit() {
		return calciumUnit;
	}

	public void setCalciumUnit(String calciumUnit) {
		this.calciumUnit = calciumUnit;
	}

	public Double getIron() {
		return iron;
	}

	public void setIron(Double iron) {
		this.iron = iron;
	}

	public String getIronUnit() {
		return ironUnit;
	}

	public void setIronUnit(String ironUnit) {
		this.ironUnit = ironUnit;
	}

	public Double getMagnesium() {
		return magnesium;
	}

	public void setMagnesium(Double magnesium) {
		this.magnesium = magnesium;
	}

	public String getMagnesiumUnit() {
		return magnesiumUnit;
	}

	public void setMagnesiumUnit(String magnesiumUnit) {
		this.magnesiumUnit = magnesiumUnit;
	}

	public Double getPhosphorus() {
		return phosphorus;
	}

	public void setPhosphorus(Double phosphorus) {
		this.phosphorus = phosphorus;
	}

	public String getPhosphorusUnit() {
		return phosphorusUnit;
	}

	public void setPhosphorusUnit(String phosphorusUnit) {
		this.phosphorusUnit = phosphorusUnit;
	}

	public Double getPotassium() {
		return potassium;
	}

	public void setPotassium(Double potassium) {
		this.potassium = potassium;
	}

	public String getPotassiumUnit() {
		return potassiumUnit;
	}

	public void setPotassiumUnit(String potassiumUnit) {
		this.potassiumUnit = potassiumUnit;
	}

	public Double getSodium() {
		return sodium;
	}

	public void setSodium(Double sodium) {
		this.sodium = sodium;
	}

	public String getSodiumUnit() {
		return sodiumUnit;
	}

	public void setSodiumUnit(String sodiumUnit) {
		this.sodiumUnit = sodiumUnit;
	}

	public Double getZinc() {
		return zinc;
	}

	public void setZinc(Double zinc) {
		this.zinc = zinc;
	}

	public String getZincUnit() {
		return zincUnit;
	}

	public void setZincUnit(String zincUnit) {
		this.zincUnit = zincUnit;
	}

	public Double getVitaminC() {
		return vitaminC;
	}

	public void setVitaminC(Double vitaminC) {
		this.vitaminC = vitaminC;
	}

	public String getVitaminCUnit() {
		return vitaminCUnit;
	}

	public void setVitaminCUnit(String vitaminCUnit) {
		this.vitaminCUnit = vitaminCUnit;
	}

	public Double getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(Double cholesterol) {
		this.cholesterol = cholesterol;
	}

	public String getCholesterolUnit() {
		return cholesterolUnit;
	}

	public void setCholesterolUnit(String cholesterolUnit) {
		this.cholesterolUnit = cholesterolUnit;
	}

	public Double getCaffeine() {
		return caffeine;
	}

	public void setCaffeine(Double caffeine) {
		this.caffeine = caffeine;
	}

	public String getCaffeineUnit() {
		return caffeineUnit;
	}

	public void setCaffeineUnit(String caffeineUnit) {
		this.caffeineUnit = caffeineUnit;
	}

	public void adjustByAmount(Double amount) {
		
		if(this.caffeine!=null){
			this.caffeine = amount * this.caffeine;
		}
		if(this.calcium!=null){
			this.calcium = amount * this.calcium;
		}
		if(this.calorie!=null){
			this.calorie = amount * this.calorie;
		}
		if(this.carbohydrate!=null){
			this.carbohydrate = amount * this.carbohydrate;
		}
		if(this.cholesterol!=null){
			this.cholesterol = amount * this.cholesterol;
		}
		if(this.fat!=null){
			this.fat = amount * this.fat;
		}
		if(this.fiber!=null){
			this.fiber = amount * this.fiber;
		}
		if(this.iron!=null){
			this.iron = amount * this.iron;
		}
		if(this.magnesium!=null){
			this.magnesium = amount * this.magnesium;
		}
		if(this.phosphorus!=null){
			this.phosphorus = amount * this.phosphorus;
		}
		if(this.potassium!=null){
			this.potassium = amount * this.potassium;
		}
		if(this.protein!=null){
			this.protein = amount * this.protein;
		}
		if(this.sodium!=null){
			this.sodium = amount * this.sodium;
		}
		if(this.sugars!=null){
			this.sugars = amount * this.sugars;
		}
		if(this.vitaminC!=null){
			this.vitaminC = amount * this.vitaminC;
		}
		if(this.water!=null){
			this.water = amount * this.water;
		}
		if(this.zinc!=null){
			this.zinc = amount * this.zinc;
		}		
	}
	
	
	
	

}
