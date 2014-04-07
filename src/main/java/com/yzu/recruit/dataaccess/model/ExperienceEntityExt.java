package com.yzu.recruit.dataaccess.model;

import com.yzu.recruit.dataaccess.model.gen.ExperienceEntity;

public class ExperienceEntityExt extends ExperienceEntity {
	private String practiceexperience;
	private String workexperience;
	private String achievement;
	private String rewards;
	private String qualification;
	private String aboutme;

	public String getPracticeexperience() {
		return practiceexperience;
	}

	public void setPracticeexperience(String practiceexperience) {
		this.practiceexperience = practiceexperience;
	}

	public String getWorkexperience() {
		return workexperience;
	}

	public void setWorkexperience(String workexperience) {
		this.workexperience = workexperience;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getRewards() {
		return rewards;
	}

	public void setRewards(String rewards) {
		this.rewards = rewards;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
}
