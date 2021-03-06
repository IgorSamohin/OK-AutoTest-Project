package Tests;

import Pages.Groups.*;
import org.junit.After;
import org.junit.Test;

public class GroupTest extends TestBase {
    private GroupMainPage groupMainPage;
    private ChooseNewGroupTypeLayer chooseNewGroupTypeLayer;
    private NewGroupPreferencesPage newGroupPreferencesPage;
    private GroupPage groupPage;
    private boolean isFall = false;

    @Test
    public void groupCreationTest() {
        String groupName = "groupName";
        String groupDescription = "groupDescription";
        //***************Test***************//
        //Go to all group page
        newGroupPreferencesPage = userMainPage.goToGroupPage()  //Go to all group page
                .createNewGroup()                               //Go to create new group page
                .choosePublicPage();                            //Choosing new group type
        //Entering the name and the description
        newGroupPreferencesPage.enterGroupName(groupName);
        newGroupPreferencesPage.enterGroupDescription(groupDescription);
        //Create new group
        groupPage = newGroupPreferencesPage.createGroup();
        //***************Check***************//
        //Checking group name, description and group type
        if (!groupPage.getGroupName().equals(groupName)) {
            System.err.println("Group name is not the same as expected\n");
            isFall = true;
        }
        if (!groupPage.getGroupDescription().equals(groupDescription)) {
            System.err.println("Group description is not the same as expected\n");
            isFall = true;
        }
        if (!groupPage.isPublicGroup()) {
            System.err.println("Group type is not the same as expected");
            isFall = true;
        }
    }

    @Override
    @After
    public void tearDown() {
        //удаление текущей группы
        groupPage.deleteGroup();
        super.tearDown();
    }
}
