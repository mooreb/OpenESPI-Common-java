/*
 *     Copyright (c) 2018-2019 Green Button Alliance, Inc.
 *
 *     Portions copyright (c) 2013-2018 EnergyOS.org
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package org.greenbuttonalliance.espi.common.domain;

import org.greenbuttonalliance.espi.common.models.atom.adapters.IntervalReadingAdapter;
import org.greenbuttonalliance.espi.common.utils.EspiMarshaller;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBElement;

import static org.junit.Assert.assertEquals;

public class IntervalReadingMarshallingTests {

	static final String XML_INPUT = "<IntervalReading xmlns=\"http://naesb.org/espi\">"
			+ "<cost>100</cost>"
			+ "<ReadingQuality>"
			+ "<quality>quality1</quality>"
			+ "</ReadingQuality>"
			+ "<ReadingQuality>"
			+ "<quality>quality2</quality>"
			+ "</ReadingQuality>"
			+ "<timePeriod>"
			+ "<duration>3</duration>"
			+ "<start>4</start>"
			+ "</timePeriod>"
			+ "<value>6</value>"
			+ "</IntervalReading>";

	private IntervalReading intervalReading;

	@Before
	public void before() throws Exception {
		IntervalReadingAdapter intervalBlockAdapter = new IntervalReadingAdapter();
		JAXBElement<IntervalReading> intervalReadingJAXBElement = EspiMarshaller
				.unmarshal(XML_INPUT);

		intervalReading = intervalBlockAdapter
				.unmarshal(intervalReadingJAXBElement);
	}

	@Test
	public void unmarshalsIntervalReading() {
		assertEquals(IntervalReading.class, intervalReading.getClass());
	}

	@Test
	public void unmarshal_setsCost() {
		assertEquals(100L, intervalReading.getCost().longValue());
	};

	@Test
	public void unmarshal_setsReadingQualities() {
		assertEquals("quality1", intervalReading.getReadingQualities().get(0)
				.getQuality());
		assertEquals(intervalReading, intervalReading.getReadingQualities()
				.get(0).getIntervalReading());
		assertEquals("quality2", intervalReading.getReadingQualities().get(1)
				.getQuality());
		assertEquals(intervalReading, intervalReading.getReadingQualities()
				.get(1).getIntervalReading());
	};

	@Test
	public void unmarshal_setsTimePeriod() {
		assertEquals(3L, intervalReading.getTimePeriod().getDuration()
				.longValue());
		assertEquals(4L, intervalReading.getTimePeriod().getStart().longValue());
	};

	@Test
	public void unmarshal_setsValue() {
		assertEquals(6L, intervalReading.getValue().longValue());
	};
}