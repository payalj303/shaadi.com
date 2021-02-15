package com.shaadi.utils.rx;

import io.reactivex.Scheduler;


/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
public interface SchedulerProvider {

    Scheduler io();

    Scheduler ui();
}
