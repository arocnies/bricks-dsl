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
        file {
            "bar" {
                copyOf("src/bar.conf")
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
                state = PackageState.PRESENT
            }
            "nginx" {
                state = PackageState.PRESENT
            }
        }
        file {
            "/etc/foo/" {
                state = FileState.PRESENT
                mode = 755
                owner = "www-data"
                group = "www-data"
            }
        }
    }
}