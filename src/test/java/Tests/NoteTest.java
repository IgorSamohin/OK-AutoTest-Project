package Tests;

import Pages.Notes.NotesCommentPage;
import Pages.UserMainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NoteTest extends TestBase {

    @Override
    @Before
    public void setUp() {
        super.setUp();
        new UserMainPage(driver)
                .goToNotesPage()
                .deleteAllNotes()
                .clickOnUserMainPage();

    }

    @Test
    public void NoCommentOnNoteTest() {

        Assert.assertTrue(
                new UserMainPage(driver)
                        .goToNotesPage()
                        .createNote()
                        .disableComments()
                        .writePost("some Text")
                        .sendPost()
                        .commentFirstNote()
                        .areCommentsDisabled()
        );
    }

    @Override
    @After
    public void tearDown() {
        new NotesCommentPage(driver)
                .clickOnUserMainPage()
                .goToNotesPage()
                .deleteAllNotes();

        super.tearDown();
    }
}
