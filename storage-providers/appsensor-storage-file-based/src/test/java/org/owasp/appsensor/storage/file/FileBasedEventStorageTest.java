package org.owasp.appsensor.storage.file;

import java.nio.file.Files;

import javax.inject.Inject;

import org.junit.Before;
import org.owasp.appsensor.core.AppSensorServer;
import org.owasp.appsensor.local.analysis.ReferenceStatisticalEventAnalysisEngineTest;
import org.owasp.appsensor.storage.file.FileBasedAttackStore;
import org.owasp.appsensor.storage.file.FileBasedEventStore;
import org.owasp.appsensor.storage.file.FileBasedResponseStore;


/**
 * Test basic FileBased * Store's by extending the ReferenceStatisticalEventAnalysisEngineTest
 * and only doing the file based setup. All of the same tests execute, but with the file
 * based stores instead of the memory based stores.
 * 
 * @author John Melton (jtmelton@gmail.com) http://www.jtmelton.com/
 * @author Raphaël Taban
 */
public class FileBasedEventStorageTest extends ReferenceStatisticalEventAnalysisEngineTest {

	@Inject
	private AppSensorServer appSensorServer;
	
	@Before
	public void deleteTestFiles() throws Exception {
		FileBasedEventStore eventStore = (FileBasedEventStore)appSensorServer.getEventStore();
		FileBasedAttackStore attackStore = (FileBasedAttackStore)appSensorServer.getAttackStore();
		FileBasedResponseStore responseStore = (FileBasedResponseStore)appSensorServer.getResponseStore();

		Files.deleteIfExists(eventStore.getPath());
		Files.deleteIfExists(attackStore.getPath());
		Files.deleteIfExists(responseStore.getPath());
	}
	
}
