import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;
import models.TestUser;

import org.junit.Test;

import play.db.jpa.JPA;
import play.libs.F.Callback;
import play.test.TestBrowser;

public class IntegrationTest {

	/**
	 * add your integration test here
	 * in this example we just check if the welcome page is being shown
	 */
	@Test
	public void test() {
		running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
			public void invoke(TestBrowser browser) {
				TestUser user = new TestUser();
				user.name = "Guilaume Bort";
				JPA.em().persist(user);
				
				Long userCount = JPA.em().createQuery("select count(u) from TestUser u", Long.class).getSingleResult();
				assertThat(userCount).equals(new Long(1));
			}
		});
	}

}
