/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.mpalourdio.springboottemplate.service;

import com.mpalourdio.springboottemplate.exception.AnotherCustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceWithPropertiesTest {

    @Test
    public void testClassPropertyIsRead() {
        ServiceWithProperties serviceWithProperties = new ServiceWithProperties("hey");
        assertEquals("hey", serviceWithProperties.getValueFromConfig());
    }

    @Test()
    public void throwExceptionTest() {
        ServiceWithProperties serviceWithProperties = new ServiceWithProperties("hey");
        assertThrows(AnotherCustomException.class, serviceWithProperties::throwException);
    }
}
