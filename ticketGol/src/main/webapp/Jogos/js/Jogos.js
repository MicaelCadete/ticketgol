const sections = document.querySelectorAll("section"),navLinks = document.querySelectorAll("nav a");

const resetLinks = () => navLinks.forEach(link => link.classList.remove("active"));

const handleScroll = () => {
    const { pageYOffset } = window;
    sections.forEach(section => {
        const { id, offsetTop, clientHeight } = section;
        const offSet = offsetTop - 1;

        if (
            pageYOffset >= offSet &&
            pageYOffset < offSet + clientHeight) {
                resetLinks();
                navLinks.forEach(link => {
                    if (link.CDATA_SECTION_NODE.scroll === id) {
                        link.classList.add("active");
                    }
                });
            }
    });
};

document.addEventListener("scroll", handleScroll);