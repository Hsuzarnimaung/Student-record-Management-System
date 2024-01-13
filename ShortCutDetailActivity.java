package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by UCSM on 10/30/2016.
 */

public class ShortCutDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailshortcutkey_layout);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Shortcut Key Detail");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));

        ArrayList arrayList=new ArrayList();
        arrayList.add("Alt + F -> File menu options in current program\n\n"+
                "Alt + E -> Edit options in current program\n\n"+
                "F1 -> Universal help (for all programs)\n\n"+
                "Ctrl + A -> Select all text\n\n"
                +"Ctrl + X -> Cut selected item\n\n"
                +"Shift + Del -> Cut selected item\n\n"
                +"Ctrl + C -> Copy selected item\n\n"
                +"Ctrl + Ins -> Copy selected item\n\n"
                +"Ctrl + V -> Paste\n\n"
                +"Shift + Ins -> Paste \n\n"
                +"Home -> Go to beginning of current line\n\n"
                +"Ctrl + Home -> Go to beginning of docement\n\n"
                +"End -> Go to end of current line\n\n"
                +"Ctrl + End -> Go to end of document\n\n"
                +"Shift + Home -> Highlight from current position to end of line\n\n"
                +"Shift + End -> Highlight from current position to end of line\n\n"
                +"Ctrl + thita symbol -> Move one word to the left at a time\n\n"
                +"Ctrl + lamda symbol -> Move one word to the right at a time\n\n");
        arrayList.add("Alt + Tab -> Switch between open applications\n\n"
                +"Alt + Shift + Tab -> Switch backwards between open applications\n\n"
                +"Alt + Print screen -> Create screen shot for current program\n\n"
                +"Ctrl + Alt + Del -> Reboot/Windows task manager\n\n"
                +"Ctrl + Esc -> Bring up start menu\n\n"
                +"Alt + Esc -> Switch between applications on taskbar\n\n"
                +"F2 -> Rename selected icon\n\n"
                +"F3 -> Start find from desktop\n\n"
                +"F4 -> Open the drive selection when browsing\n\n"
                +"F5 -> Refresh contents\n\n"
                +"Alt + F4 -> Close current open program\n\n"
                +"Ctrl + F4 -> Close window in program\n\n"
                +"Ctrl + Plus key -> Automatically adjust widths of all columns in Windows Explorer\n\n"
                +"Alt + Enter -> Open properties window of selected icon or program\n\n"
                +"Shift + Del -> Delete programs/files permanently\n\n"
                +"Holding Shift During Bootup -> Boot safe mode or bypass system files\n\n");
        arrayList.add("WINKEY + D -> Bring desktop to the top of other windows\n\n"
                +"WINKEY + M -> Minimize all windows\n\n"
                +"WINKEY + SHIFT + M -> Undo the minimize done by WINKEY + M and WINKEY + D\n\n"
                +"WINKEY + E -> Open Microsoft Explorer\n\n"
                +"WINKEY + Tab -> Cycle through open programs on taskbar\n\n"
                +"WINKEY + F -> Display the search for computers window\n\n"
                +"WINKEY + CTRL + F -> Display the search for computers window\n\n"
                +"WINKEY + F1 -> Display the Microsoft Windows help\n\n"
                +"WINKEY + R -> Open the run window\n\n"
                +"WINKEY + Pause/Break -> Open the system properties window\n\n"
                +"WINKEY + U -> Open utility manager\n\n"
                +"WINKEy + L -> Lock the computer (Windows XP & later)\n\n");
        arrayList.add("Ctrl + A -> Select all contents of the page\n\n"
                +"Ctrl + B -> Bold highlighed selection\n\n"
                +"Ctrl + C -> Copy selected text\n\n"
                +"Ctrl + X -> Cut selected text\n\n"
                +"Ctrl + N -> Open new/blank document\n\n"
                +"Ctrl + O -> Open options\n\n"
                +"Ctrl + P -> Open the print window\n\n"
                +"Ctrl + F -> Open find box\n\n"
                +"Ctrl + I -> Italicize highlighted selection\n\n"
                +"Ctrl + K -> Insert link\n\n"
                +"Ctrl + U -> Underline highlighted selection\n\n"
                +"Ctrl + V -> Paste\n\n"
                +"Ctrl + Y -> Redo the last action performed\n\n"
                +"Ctrl + Z -> Undo last action\n\n"
                +"Ctrl + G -> Find and replace options\n\n"
                +"Ctrl + H -> Find and replace options\n\n"
                +"Ctrl + J -> Justify paragraph alignment\n\n"
                +"Ctrl + L -> Align selected text or line to the left\n\n"
                +"Ctrl + Q -> Align selected paragraph to the left\n\n"
                +"Ctrl + E -> Align selected text or line to the center\n\n"
                +"Ctrl + R -> Align selected text or line to the right\n\n"
                +"Ctrl + M -> Indent the paragraph\n\n"
                +"Ctrl + T -> Hanging indent\n\n"
                +"Ctrl + D -> Font options\n\n"
                +"Ctrl + Shift + F -> Change the font\n\n"
                +"Ctrl + Shift + > -> Increase selected font + 1\n\n"
                +"Ctrl + ] -> Increase selected font -1\n\n"
                +"Ctrl + Shift + < -> Decrease selected font -1\n\n"
                +"Ctrl + [ -> Decrease selected font -1\n\n"
                +"Ctrl + Shift + * ->View or hide non printing characters\n\n"
                +"Ctrl + thita symbol -> Move one word to the left\n\n"
                +"Ctrl + lamda symbol -> Move one word to the right\n\n"
                +"Ctrl + Del -> Delete word to right of cursor\n\n"
                +"Ctrl + Backspace -> Delete word to left or cursor\n\n"
                +"Ctrl + End -> Move cursor to end of document\n\n"
                +"Ctrl + Home -> Move cursor to beginning of document\n\n"
                +"Ctrl + Space -> Reset highlighted text to default font\n\n"
                +"Ctrl + 1 -> Single-space lines\n\n"
                +"Ctrl + 2 -> Double-space lines\n\n"
                +"Ctrl + 5 -> 1.5-line spacing\n\n"
                +"Ctrl + Alt + 1 -> Change text to heading 1\n\n"
                +"Ctrl + Alt + 2 -> Change text to heanding 2\n\n"
                +"Ctrl + Alt + 1 -> Change text to heading 3\n\n"
                +"F1 -> Open help\n\n"
                +"Shift + F3 -> Change case of selected text\n\n"
                +"Shift + Insert -> Paste\n\n"
                +"F4 -> Repeat last action performed\n\n"
                +"F7 ->Spell check selected text and/or document\n\n"
                +"Shift + F7 -> Activate the thesaurus\n\n"
                +"F12 -> Save as\n\n"+"Ctrl + S -> Save\n\n"
                +"Alt + Shift + D -> Insert the current date\n\n"
                +"Alt + Shift + T -> Insert the current time\n\n"
                +"Ctrl + W ->Close document\n\n");
        arrayList.add("F2 -> Edit the selected cell\n\n"+"F5 -> Go to a specific cell\n\n"+"F7 -> Spell check selected text and/or document\n\n"
                +"F11 -> Create chart\n\n"+"Ctrl + Shift + ; ->Enter the current time\n\n"+"Ctrl + ; -> Enter the current date\n\n"
                +"Alt + Shift + F1 -> Insert new worksheet\n\n"+"Shift + F3 -> Open the Excel formula window\n\n"+"Shift + F5 -> Bring up search box\n\n"
                +"Ctrl + A -> Select all contents of worksheet\n\n"+"Ctrl + B -> Bold highlighted selection\n\n"+"Ctrl + I -> Italicize highlighted selection\n\n"
                +"Ctrl + C -> Copy selected text\n\n"+"Ctrl + V -> Paste\n\n"+"Ctrl + D -> Fill\n\n"
                +"Ctrl + K -> Insert link\n\n"
                +"Ctrl + F -> Open find and replace options\n\n"+"Ctrl + G -> Open go-to options\n\n"
                +"Ctrl + H -> Open find and replace options\n\n"+"Ctrl + U -> Underline hightlighted selection\n\n"
                +"Ctrl + Y -> Underline selected text\n\n"+"Ctrl + 5 -> Strikethrough highlighted selection\n\n"+"Ctrl + O -> Open options\n\n"
                +"Ctrl + N -> Open new document\n\n"+"Ctrl + P -> Open print dialog box\n\n"+"Ctrl + S -> Save\n\n"+"Ctrl + Z -> Undo last action\n\n"
                +"Ctrl + F9 -> Minimize current window\n\n"+"Ctrl + F10 -> Maximize currently selected windows\n\n"+"Ctrl + F6 -> Switch between open workbooks/windows\n\n"
                +"Ctrl + Page Up & Page Down -> Move between Excel worksheets in the same document\n\n"
                +"Ctrl + Tab -> Move between two or more open Excel files\n\n"+"Alt + = -> Create formula to sum all of above cells\n\n"
                +"Ctrl + ' -> Insert value of above cell into current cell\n\n"+"Ctrl + Shift + ! -> Format number in comma format\n\n"
                +"Ctrl + Shift + $ ->Format number in date format\n\n"+"Ctrl + Shift + # ->Format number in percentage format\n\n"
                +"Ctrl + Shift + % ->Format number in scientific format\n\n"+"Ctrl + Shift + @ -> Format number in time format\n\n"+"Ctrl + Shift -> Select entire column \n\n"
                +"Shift + space -> Select entire row\n\n"+"Ctrl + W -> Close document\n\n");
        arrayList.add("Alt + S -> Send the email\n\n"+"Ctrl + C -> Copy selected text\n\n"+"Ctrl + X -> Cut selected text\n\n"+"Ctrl + P -> Open print dialog box\n\n"
                +"Ctrl + K -> Complete name/email typed in address bar\n\n"+"Ctrl + B -> Bold highlighted selection\n\n"
                +"Ctrl + I -> Italicize highlighted selection\n\n"+"Ctrl + U -> Underline highlighted selection\n\n"
                +"Ctrl + R -> Reply to an email\n\n"+"Ctrl + F -> Forward an email\n\n"+"Ctrl + N ->Create a new email\n\n"+"Ctrl + Shift + A -> Create a new appointment to your calendar\n\n"
                +"Ctrl + Shift + O -> Open the outbox\n\n"+"Ctrl + Shift + I -> Open the inbox\n\n"+"Ctrl + Shift + K -> Add a new task\n\n"+"Ctrl + Shift + C -> Create a new contact\n\n"
                +"Ctrl + Shift + J -> Create a new journal entry\n\n");

        TextView txtDetail=(TextView)findViewById(R.id.txtDetail);
        Intent intent=getIntent();
       int position=intent.getIntExtra("shortcutposition",1);
        txtDetail.setText((CharSequence) arrayList.get(position));




    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent=new Intent(getApplicationContext(),ShortKeyActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
