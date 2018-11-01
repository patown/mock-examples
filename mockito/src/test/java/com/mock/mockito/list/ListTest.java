package com.mock.mockito.list;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class ListTest {
	  @Rule
	     public ExpectedException thrown= ExpectedException.none();
	@Test
	public void T01_VerifyInterationTest() {

	// mock creation
	List<String> mockedList = mock(List.class);

	// using mock object - it does not throw any "unexpected interaction" exception
	mockedList.add("one");
	mockedList.clear();

	// selective, explicit, highly readable verification
	verify(mockedList).add("one");
	verify(mockedList).clear();
	}
	
	@Test
	public void T02_ThenReturnTest() {

		// you can mock concrete classes, not only interfaces
		LinkedList mockedList = mock(LinkedList.class);

		// stubbing appears before the actual execution
		when(mockedList.get(0)).thenReturn("first");
        assertThat(mockedList.get(0)).isEqualTo("first");
        assertThat(mockedList.get(666)).isNull();
	}
	
	@Test
	public void T03_DoThrowTest() {
		thrown.expect(RuntimeException.class);
        List list = mock(List.class);
        doThrow(new RuntimeException()).when(list).add(1);
        list.add(1);
	}
	
	@Test
	public void T04_VerifySequenceTest() {
	List<String> mockedList = mock(List.class);
	mockedList.add("one");
	mockedList.add("two");
	 InOrder inOrder = inOrder(mockedList);
     inOrder.verify(mockedList).add("one");
	 inOrder.verify(mockedList).add("two");
	// inOrder.verify(mockedList).add("one");
	}
	
    @Test
    public void T05_PartialMock(){
        List list = spy(new ArrayList());
		when(list.size()).thenReturn(0).thenCallRealMethod();
        list.add("one"); 
        assertThat(list.size()).isZero();
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void T06_VrifyingInvocations(){
        List list = mock(List.class);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
  
        verify(list).add(1);
        verify(list,times(1)).add(1);

        verify(list,times(2)).add(2);

        verify(list,times(3)).add(3);

        verify(list,never()).add(4);

        verify(list,atLeastOnce()).add(1);

        verify(list,atLeast(2)).add(2);

        verify(list,atMost(3)).add(3);
    }
}
