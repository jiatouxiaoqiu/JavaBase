package cn.ebing.dog.api.domain.entity;

import java.io.Serializable;

public class ForecastUnitEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String unitId;
	private String unitName;
	private String unitDec;

	private String unitCategory;
	private String unitCategoryNm;

	private String interestSubclass;
	private String interestSubclassNm;

	private String unitProject;
	private String unitProjectNm;

	private String calculationMethod;

	private String dateSources;

	private String customType;
	private String customTypeNm;

	private String crtUsr;
	private String crtNm;
	private String crtDt;

	private String uptUsr;
	private String uptNm;
	private String uptDt;

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitDec() {
		return unitDec;
	}

	public void setUnitDec(String unitDec) {
		this.unitDec = unitDec;
	}

	public String getUnitCategory() {
		return unitCategory;
	}

	public void setUnitCategory(String unitCategory) {
		this.unitCategory = unitCategory;
	}

	public String getUnitCategoryNm() {
		return unitCategoryNm;
	}

	public void setUnitCategoryNm(String unitCategoryNm) {
		this.unitCategoryNm = unitCategoryNm;
	}

	public String getInterestSubclass() {
		return interestSubclass;
	}

	public void setInterestSubclass(String interestSubclass) {
		this.interestSubclass = interestSubclass;
	}

	public String getInterestSubclassNm() {
		return interestSubclassNm;
	}

	public void setInterestSubclassNm(String interestSubclassNm) {
		this.interestSubclassNm = interestSubclassNm;
	}

	public String getUnitProject() {
		return unitProject;
	}

	public void setUnitProject(String unitProject) {
		this.unitProject = unitProject;
	}

	public String getUnitProjectNm() {
		return unitProjectNm;
	}

	public void setUnitProjectNm(String unitProjectNm) {
		this.unitProjectNm = unitProjectNm;
	}

	public String getCalculationMethod() {
		return calculationMethod;
	}

	public void setCalculationMethod(String calculationMethod) {
		this.calculationMethod = calculationMethod;
	}

	public String getDateSources() {
		return dateSources;
	}

	public void setDateSources(String dateSources) {
		this.dateSources = dateSources;
	}

	public String getCustomType() {
		return customType;
	}

	public void setCustomType(String customType) {
		this.customType = customType;
	}

	public String getCustomTypeNm() {
		return customTypeNm;
	}

	public void setCustomTypeNm(String customTypeNm) {
		this.customTypeNm = customTypeNm;
	}

	public String getCrtUsr() {
		return crtUsr;
	}

	public void setCrtUsr(String crtUsr) {
		this.crtUsr = crtUsr;
	}

	public String getCrtNm() {
		return crtNm;
	}

	public void setCrtNm(String crtNm) {
		this.crtNm = crtNm;
	}

	public String getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getUptUsr() {
		return uptUsr;
	}

	public void setUptUsr(String uptUsr) {
		this.uptUsr = uptUsr;
	}

	public String getUptNm() {
		return uptNm;
	}

	public void setUptNm(String uptNm) {
		this.uptNm = uptNm;
	}

	public String getUptDt() {
		return uptDt;
	}

	public void setUptDt(String uptDt) {
		this.uptDt = uptDt;
	}
}
