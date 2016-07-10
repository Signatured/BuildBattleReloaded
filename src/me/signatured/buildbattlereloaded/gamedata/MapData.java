package me.signatured.buildbattlereloaded.gamedata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.signatured.buildbattlereloaded.util.Cuboid;

@Getter @Setter
@AllArgsConstructor
public class MapData {
	
	private Cuboid floorBounds;
	private Cuboid flyingBounds;
}
