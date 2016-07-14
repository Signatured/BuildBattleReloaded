package me.signatured.buildbattlereloaded.gamedata.plotdata;

import lombok.Getter;

@Getter
public enum PlotTime {
	
	DAY("Day", 1000),
	NIGHT("Night", 13000);
	
	private String name;
	private int time;
	
	PlotTime(String name, int time) {
		this.name = name;
		this.time = time;
	}
}
