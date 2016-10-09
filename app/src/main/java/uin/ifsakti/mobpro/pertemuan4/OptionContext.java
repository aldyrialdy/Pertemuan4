package uin.ifsakti.mobpro.pertemuan4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OptionContext extends AppCompatActivity {

    EditText etMessage1;
    EditText etMessage2;
    Integer[] arrayPointSize = {10, 20, 30, 40, 50};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_context);
        etMessage1 = (EditText) findViewById(R.id.etMessage1);
        etMessage2 = (EditText) findViewById(R.id.etMessage2);

        // you may register an individual context menu for each view
        registerForContextMenu(etMessage1);
        registerForContextMenu(etMessage2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menus, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menus, v, menuInfo);
        if (v.getId() == etMessage1.getId())
            // create a menu for etMessage1 box
            populateMyFirstMenu(menus);
        if (v.getId() == etMessage2.getId()) {
            // create a menu for etMessage2 box
            populateMySecondMenu(menus);
        }
    }

    private void populateMySecondMenu(ContextMenu menus) {
        int groupId = 0;
        int order = 0;

        //arguments: groupId, optionId, order, title
        menus.add(groupId, 1, 1, "10 points");
        menus.add(groupId, 2, 2, "20 points");
        menus.add(groupId, 3, 3, "30 points");
        menus.add(groupId, 4, 4, "40 points");
        menus.add(groupId, 5, 5, "50 points");
        menus.add(groupId, 6, 8, "Red text");
        menus.add(groupId, 7, 7, "Green Text");
        menus.add(groupId, 8, 6, "Blue text");
    }

    private void populateMyFirstMenu(ContextMenu menus) {
        int groupId = 0;
        int order = 0;
        //arguments: groupId, optionId, order, title
        menus.add(groupId, 9, 1, "Bold");
        menus.add(groupId, 10, 2, "Italic");
        menus.add(groupId, 11, 3, "Normal");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menux) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menux);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_bookmark:
                // Single menu item is selected do something
                // Ex: launching new activity/screen or show alert message
                Toast.makeText(OptionContext.this, "Bookmark is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_save:
                Toast.makeText(OptionContext.this, "Save is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_search:
                Toast.makeText(OptionContext.this, "Search is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_share:
                Toast.makeText(OptionContext.this, "Share is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_delete:
                Toast.makeText(OptionContext.this, "Delete is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_preferences:
                Toast.makeText(OptionContext.this, "Preferences is Selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
