package com.budlee.orderapi.model.error.microsoft;

import lombok.Value;

/**
 * https://github.com/Microsoft/api-guidelines/blob/master/Guidelines.md#51-errors
 * {
 *   "error": {
 *     "code": "BadArgument",
 *     "message": "Previous passwords may not be reused",
 *     "target": "password",
 *     "innererror": {
 *       "code": "PasswordError",
 *       "innererror": {
 *         "code": "PasswordDoesNotMeetPolicy",
 *         "minLength": "6",
 *         "maxLength": "64",
 *         "characterTypes": ["lowerCase","upperCase","number","symbol"],
 *         "minDistinctCharacterTypes": "2",
 *         "innererror": {
 *           "code": "PasswordReuseNotAllowed"
 *         }
 *       }
 *     }
 *   }
 * }
 */
@Value
public class InnerError {

    /**
     * A more specific error code than was provided by the containing error.
     */
    private String code;

    /**
     * An object containing more specific information than the current object about the error.
     */
    private InnerError innerError;
}
