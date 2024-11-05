## Non ReEntrant Locks
when using synchronized blocks or ReentrantLock, reentrancy is always supported, so a thread can lock a resource it already holds without issue. However, some locking mechanisms do not support reentrancy by design, and attempting to re-enter them results in a deadlock.

## Explanation
- The NonReentrantLock class does not allow reentrant locking. If a thread tries to lock it while already holding the lock, it will enter an indefinite wait (a deadlock).
- In outerMethod(), we acquire the lock and then call innerMethod(), which tries to acquire the same lock again.
- Since lock is already held by the same thread, it will wait indefinitely, causing a deadlock.