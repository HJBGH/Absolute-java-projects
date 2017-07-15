package chapter17projectsSwingOne;

import java.util.ArrayList;

/**
 * One off interface for implementing the observer pattern. This class isn't really generic
 * @author hb
 *
 */
public interface Watchable{
	void addWatcher(Watcher watcher);
	void notifyAll(Watcher watcher);
	void removeAll(Watcher watcher);
}
