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
		float length = 120;

		assertEquals(chipMap.getCells()[0][3], new Rectangle(0, 360, length, length));
		assertEquals(chipMap.getCells()[3][0], new Rectangle(360, 0, length, length));
		assertEquals(chipMap.getCells()[3][3], new Rectangle(360, 360, length, length));
	}
}