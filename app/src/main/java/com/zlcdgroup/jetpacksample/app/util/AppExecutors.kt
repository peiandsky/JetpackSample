/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zlcdgroup.jetpacksample.app.util

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

object AppExecutors {

    val IO_EXECUTOR = Executors.newSingleThreadExecutor()

    val NETWORK_EXECUTOR = Executors.newFixedThreadPool(3)

    val MAIN_THREAD_EXECUTOR = Handler(Looper.getMainLooper())

    /**
     * Utility method to run blocks on a dedicated background thread, used for io/database work.
     */
    fun runOnIoThread(f: () -> Unit) {
        IO_EXECUTOR.execute(f)
    }

    fun runOnMainThread(f: () -> Unit) {
        MAIN_THREAD_EXECUTOR.post(f)
    }

    fun runOnNetworkThread(f: () -> Unit) {
        NETWORK_EXECUTOR.execute(f)
    }

}
