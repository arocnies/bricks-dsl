import com.anies.bricks.*

/**
 * Created by anies on 6/13/17.
 */

fun main(args: Array<String>) {
    val state = state {
        apt {
            "httpd" {

            }
        }
        apt("httpd") {

        }

        file("foo") {
            copyOf("src/foo.conf")
        }
        file {
            "bar" {

            }
        }
        file {
            "/etc/foo.conf" copyOf "src/foo.conf"
        }
    }
}