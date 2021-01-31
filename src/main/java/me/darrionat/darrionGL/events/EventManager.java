package me.darrionat.darrionGL.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import me.darrionat.darrionGL.events.annotations.EventHandler;
import me.darrionat.darrionGL.events.interfaces.Listener;

public class EventManager {

	/**
	 * All Listeners which will be ran through every time an event is called
	 */
	private static List<Listener> listeners = new ArrayList<Listener>();

	/**
	 * Events to create
	 * 
	 * PressedComponentEvent(but not released)
	 * 
	 * ReleasedComponentEvent(end of click)
	 * 
	 * DraggedComponentEvent
	 * 
	 * MouseWheeledComponentEvent
	 */

	public static List<Listener> getListeners() {
		return listeners;
	}

	/**
	 * Adds a Listener to {@link #listeners}}. Duplicates can exist, meaning that if
	 * a Listener is added more than once, it's events will be fired multiple times.
	 * 
	 * @param listener the Listener to add to the List of listeners.
	 */
	public static void registerListener(Listener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes a Listener from {@link #listeners}
	 * 
	 * @param listener the listener to remove
	 */
	public static void removeListener(Listener listener) {
		listeners.remove(listener);
	}

	/**
	 * Invokes all listeners to run the particular event, if they have the event
	 * within them
	 * 
	 * @param event
	 */
	public static void callEvent(UiEvent event) {
		for (Listener listener : listeners)
			for (Method method : listener.getClass().getDeclaredMethods()) {
				if (event.isCancelled())
					break;
				// Method can be ran for the particular event
				if (!methodCompatibleWithEvent(event, method))
					continue;
				// Run method
				method.setAccessible(true);
				try {
					method.invoke(listener, event);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
	}

	/**
	 * Checks to see if a particular method contains only one parameter which is a
	 * UiEvent and that event is the same type as the defined event. The method must
	 * also have the EventHandler annotation to return {@code true}.
	 * 
	 * @param event  the event to see if it's passed through the given method
	 * @param method the method to check to see if
	 * @return returns {@code true} if the given method has the EventHandler
	 *         annotation, and it passes only parameter which is the same type as
	 *         the {@code event}.
	 */
	private static boolean methodCompatibleWithEvent(UiEvent event, Method method) {
		// Must have EventHandler annotation
		if (method.getAnnotation(EventHandler.class) == null)
			return false;

		/**
		 * Gets the event name from the parameters of the method
		 */
		Parameter[] parameters = method.getParameters();

		// Only can have one parameter
		if (parameters.length != 1)
			return false;

		Parameter parameter = parameters[0];
		String paramTypeName = parameter.getParameterizedType().getTypeName();

		// Events class name and parameter's class name are the same
		return event.getClass().getName().equals(paramTypeName);
	}
}