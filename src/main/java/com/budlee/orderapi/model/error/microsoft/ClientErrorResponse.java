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
public class ClientErrorResponse {
    /**
     * The error object.
     */
    private final ClientError error;
}
