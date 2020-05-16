package Tests;

import Pages.Groups.ChooseNewGroupTypeLayer;
import Pages.Groups.GroupMainPage;
import Pages.Groups.GroupPage;
import Pages.Groups.NewGroupPreferencesPage;
import Pages.UserMainPage;
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
        String groupName = "1";
        String groupDescription = "2fdddd";
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
        if(!groupPage.getGroupName().equals(groupName)){
            System.err.println("Group name is not the same as expected\n");
            isFall = true;
        }
        if(!groupPage.getGroupDescription().equals(groupDescription)){
            System.err.println("Group description is not the same as expected\n");
            isFall = true;
        }
        if(!groupPage.isPublicGroup()){
            System.err.println("Group type is not the same as expected");
            isFall = true;
        }
    }

    @Override
    @After
    public void tierDown() {
        //удаление текущей группы
        groupPage.deleteGroup();
        super.tierDown();
    }
}
