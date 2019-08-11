/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.mpalourdio.springboottemplate;

import app.config.BeansFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mpalourdio.springboottemplate.model.entities.People;
import com.mpalourdio.springboottemplate.model.entities.Task;
import com.mpalourdio.springboottemplate.properties.CredentialsProperties;
import com.mpalourdio.springboottemplate.properties.MarvelProperties;
import com.mpalourdio.springboottemplate.properties.MyPropertyConfigHolder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:test.properties")
@Import({BeansFactory.class})
@EnableConfigurationProperties({MyPropertyConfigHolder.class, MarvelProperties.class, CredentialsProperties.class})
public abstract class AbstractTestRunner {

    protected Task task;
    protected People people;

    protected void initializeData() {
        task = new Task();
        task.setTaskArchived(true);
        task.setTaskName("name");
        task.setTaskDescription("description");
        task.setTaskPriority("LOW");
        task.setTaskStatus("ACTIVE");

        people = new People()
                .setName("john")
                .setTask(task);
    }

    protected String serializeToJson(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}
