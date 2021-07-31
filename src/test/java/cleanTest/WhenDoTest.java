package cleanTest;

import activities.whenDo.CreateTaskScreen;
import activities.whenDo.DeleteTaskScreen;
import activities.whenDo.MainScreen;
import activities.whenDo.UpdateTaskScreen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import session.Session;

import java.net.MalformedURLException;

public class WhenDoTest {

    private MainScreen mainScreen= new MainScreen();
    private CreateTaskScreen createTaskScreen= new CreateTaskScreen();
    private UpdateTaskScreen updateTaskScreen= new UpdateTaskScreen();
    private DeleteTaskScreen deleteTaskScreen= new DeleteTaskScreen();

    @Before
    public void verifyCreateTask() throws MalformedURLException {
        String title="CLEAN";
        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.setValue(title);
        createTaskScreen.descriptionTextBox.setValue("this is a description");
        createTaskScreen.saveButton.click();
        Assert.assertEquals("ERROR! task was not created",title,mainScreen.nameTaskLabel.getText());
    }

    @Test
    public void verifyUpdateTask() throws MalformedURLException {
        String updatetitle="UPDATE";
        mainScreen.nameTaskLabel.click();
        updateTaskScreen.titleTextBoxUpdate.setValue(updatetitle);
        updateTaskScreen.descriptionTextBoxUpdate.setValue("update descripcion");
        createTaskScreen.saveButton.click();
        Assert.assertEquals("ERROR! task was not updated",updatetitle,mainScreen.nameTaskLabel.getText());
    }

    @Test
    public void verifyDeleteTask() throws MalformedURLException {
        mainScreen.nameTaskLabel.click();
        deleteTaskScreen.deleteButton.click();
        deleteTaskScreen.confirmDeleteButton.click();
        Assert.assertEquals("ERROR! task was not deleted",0,mainScreen.nameTaskLabel.size());
    }

    @After
    public void close() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
