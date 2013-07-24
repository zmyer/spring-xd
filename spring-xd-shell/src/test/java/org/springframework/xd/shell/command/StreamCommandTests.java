/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.xd.shell.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.shell.core.CommandResult;
import org.springframework.xd.shell.AbstractShellIntegrationTest;

@Ignore("Not able to stop embedded tomcat container")
public class StreamCommandTests extends AbstractShellIntegrationTest {


	private static final Log logger = LogFactory.getLog(StreamCommandTests.class);

	@Test
	@Ignore("Not able to stop embedded tomcat container")
	public void testStreamLifecycleForTickTock() throws InterruptedException {
		logger.info("Starting Stream Test for TickTock");
		System.out.println("Starting Stream Test for TickTock");
		
		CommandResult cr = getShell().executeCommand("stream create --definition \"time | log\" --name ticktock");
		assertTrue(cr.isSuccess());
		assertEquals("Created new stream 'ticktock'", cr.getResult());
		
		
		Thread.sleep(2000);
		cr = getShell().executeCommand("stream destroy --name ticktock");
		System.out.println(cr);
		assertTrue(cr.isSuccess());
		
	}
}
