package com.example.notetakingtask;

import android.app.Application;

import com.example.notetakingtask.addNote.AddNoteViewModel;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddNoteViewModelUnitTest
{
    //Constants
    private final String TITLE = "title";
    private final String NOTE = "note";
    private final String EMPTY_WITH_SPACE = " ";
    private final String NULL = null;

    @Mock
    Application mApplicationMock;

    @Test
    public void isTitleNoteNotEmpty_checkIfTitleAndNoteIsNotEmpty()
    {
        AddNoteViewModel addNoteViewModel = Mockito.spy(new AddNoteViewModel(mApplicationMock));

        boolean isNotEmpty = addNoteViewModel.isTitleNoteNotEmpty(TITLE , NOTE) && !addNoteViewModel.isTitleNoteNotEmpty(EMPTY_WITH_SPACE, EMPTY_WITH_SPACE)
                && !addNoteViewModel.isTitleNoteNotEmpty(EMPTY_WITH_SPACE, NOTE)
                && !addNoteViewModel.isTitleNoteNotEmpty(TITLE , EMPTY_WITH_SPACE)
                && !addNoteViewModel.isTitleNoteNotEmpty(NULL, NULL)
                && !addNoteViewModel.isTitleNoteNotEmpty(NULL, NOTE)
                && !addNoteViewModel.isTitleNoteNotEmpty(TITLE , NULL);

        assertTrue(isNotEmpty);
    }

    @After
    public void tearDown() throws Exception {
        mApplicationMock = null;
    }

}