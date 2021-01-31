package me.darrionat.darrionGL.animations;

import java.util.Timer;
import java.util.TimerTask;

import me.darrionat.darrionGL.UI;
import me.darrionat.darrionGL.components.UiComponent;

public abstract class UiAnimation {

	/**
	 * The base timer which runs the animation
	 */
	private Timer timer;
	private boolean running = false;

	/**
	 * The component that is being animated
	 */
	protected UiComponent component;

	/**
	 * The delay before running the animation in milliseconds
	 */
	private long delay = 0;

	/**
	 * Frames per second of the animations. This dictates how many times per second
	 * the animation will be graphically updated.
	 */
	protected int fps = 60;

	/**
	 * Creates a new UiAnimation object. This animation will update the given
	 * UiContainer every frame. It will also pass the defined UiComponent through
	 * {@link #animate(UiComponent)} every frame.
	 * 
	 * @param container   the container the component is located within; therefore,
	 *                    the container the animation is taking place in
	 * @param uiComponent the animation to be passed through
	 *                    {@link #animate(UiComponent)} every frame
	 * 
	 * @see #start()
	 * @see #cancel()
	 */
	public UiAnimation(UiComponent uiComponent) {
		this.component = uiComponent;
	}

	/**
	 * Gets the interval of which the animation is updated per second. Default is 60
	 * frames per second.
	 * 
	 * @return returns the amount of frames per second the animation is running at
	 */
	public int getFramesPerSecond() {
		return fps;
	}

	/**
	 * Changes the interval of which the animation is updated per second. Default is
	 * 60 frames per second. The UiContainer is repainted every frame.
	 * 
	 * @param fps the amount of frames per second to set the animation to
	 */
	public void setFramesPerSecond(int fps) {
		this.fps = fps;
	}

	/**
	 * Gets the delay in milliseconds of which the animation will wait to be ran.
	 * 
	 * @return returns the delay of the animation in seconds
	 */
	public long getDelay() {
		return delay;
	}

	/**
	 * Changes the delay of which the animation waits (in milliseconds) before it
	 * will run. This method is not retroactive, meaning if the animation is already
	 * running, it will not further delay the animation.
	 * 
	 * @param the new delay (in milliseconds) to wait before the animation will run
	 */
	public void setDelay(long delay) {
		this.delay = delay;
	}

	/**
	 * Starts the animation. The animation will be ran at a rate defined by the
	 * frames per second.
	 */
	public void start() {
		timer = new Timer();
		running = true;
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				animate(component);
				UI.getContainer().repaint();
			}
		}, delay, (1000 / fps));
	}

	/**
	 * Ran every frame of the animation. This will be where the animation changes
	 * should be taking place.
	 * 
	 * @param the UiComponent being animated
	 */
	protected abstract void animate(UiComponent component);

	/**
	 * Stops the animation. If a subclass overrides this method, the superclass
	 * method of {@link #cancel()} should still be ran to stop the timer.
	 */
	public void cancel() {
		timer.cancel();
		running = false;
	}

	public boolean isRunning() {
		return running;
	}
}