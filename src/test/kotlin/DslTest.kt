import com.anies.bricks.*
import com.anies.bricks.apt.apt
import com.anies.bricks.file.file

/**
 * Created by anies on 6/13/17.
 */

fun main(args: Array<String>) {
    val state = state {
        apt {
            "httpd" {

            }
        }
        file {
            "bar" {
                state = copyOf("src/bar.conf")
                owner = ""
                mode = 777
            }


            "foo" {

            }
        }
        file {
            "/etc/foo.conf" copyOf "src/foo.conf"
        }


        // -----

        apt {
            "ppa:nginx/stable" {
                state = present()
            }
            "nginx" {
                state = any()
            }
        }
        file {
            "/etc/foo/" {
                state = copyOf("../foo")
                mode = 755
                owner = "www-data"
                group = "www-data"
            }
        }
        file {
            "bar" { state = present() }
        }
    }
}