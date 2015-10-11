package com.nilmedov.fifteen;

import com.badlogic.gdx.math.Rectangle;
import com.nilmedov.fifteen.entities.Chip;
import com.nilmedov.fifteen.entities.ChipMap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nazar on 10.10.2015.
 */
public class ChipMapTest {

	@Test
	public void testConstructor() throws Exception {
		ChipMap chipMap = new ChipMap(null, 4, 4);
		float length = Chip.getLength();

		assertEquals(chipMap.getCells()[0][3], new Rectangle(0, length * 3, length, length));
		assertEquals(chipMap.getCells()[3][0], new Rectangle(length * 3, 0, length, length));
		assertEquals(chipMap.getCells()[3][3], new Rectangle(length * 3, length * 3, length, length));

		assertEquals(chipMap.getBound(), new Rectangle(0, 0, length * 4, length * 4));
	}
}