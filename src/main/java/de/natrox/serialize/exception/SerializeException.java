/*
 * Copyright 2020-2022 NatroxMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.natrox.serialize.exception;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;

public class SerializeException extends Exception {

    private @Nullable Type expectedType;

    public SerializeException() {

    }

    public SerializeException(String message) {
        super(message);
    }

    public SerializeException(Throwable cause) {
        super(cause);
    }

    public SerializeException(@Nullable Type expectedType, String message) {
        super(message);
        this.expectedType = expectedType;
    }

    public SerializeException(@Nullable Type expectedType, Throwable cause) {
        super(cause);
        this.expectedType = expectedType;
    }

    public SerializeException(@Nullable Type expectedType, String message, Throwable cause) {
        super(message, cause);
        this.expectedType = expectedType;
    }

    public @Nullable Type expectedType() {
        return this.expectedType;
    }
}
