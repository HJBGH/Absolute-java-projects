package chapter17projectsSwingOne;


/**
 * One off interface for implementing the observer pattern. This class isn't really generic
 * @author hb
 *
 */
public interface Watchable{
	void addWatcher(Watcher watcher);
	void notifyWatchers(); //Simply calls notify(Watchable watchable) on all watchers
	void notifyWatchersOfNews(String news); //Calls notify(String news) on all watchers, 
	void removeAll(Watcher watcher);
}
