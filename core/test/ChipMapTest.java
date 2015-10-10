package com.nilmedov.fifteen;

import com.badlogic.gdx.math.Rectangle;
import com.nilmedov.fifteen.entities.ChipMap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nazar on 10.10.2015.
 */
public class ChipMapTest {

	@Test
	public void testConstructor() throws Exception {
		ChipMap chipMap = new ChipMap(4, 4);
//		float length = Chip.getLength();
		for (Rectangle[] cellRows: chipMap.getCells()) {
			for (Rectangle cell : cellRows) {
				assertNotNull(cell);
			}
		}
//		assertEquals(chipMap.getCells()[0][0], new Rectangle(0, 0, ));
	}
}
