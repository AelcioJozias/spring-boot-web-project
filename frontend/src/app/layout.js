import localFont from "next/font/local";
import "./globals.css";
import Link from "next/link";

const geistSans = localFont({
    src: "./fonts/GeistVF.woff",
    variable: "--font-geist-sans",
    weight: "100 900",
});
const geistMono = localFont({
    src: "./fonts/GeistMonoVF.woff",
    variable: "--font-geist-mono",
    weight: "100 900",
});

export const metadata = {
    title: "Senai",
    description: "Projeto Frontend senai",
};

export default function RootLayout({children}) {
    return (
        <html lang="pt-br">
        <body
            className={`${geistSans.variable} ${geistMono.variable} antialiased`}
        >
        <div className="min-h-screen flex-1 flex-col">
            <header className="bg-blue-500  text-white text-center">
                <div className="mx-16 p-4 flex justify-between  ">
                    <h1><Link href="/">Jozias Tech</Link></h1>
                    <nav>
                        <ul className="flex justify-center gap-6">
                            <li>
                                <Link href="/" className="hover:underline">Home</Link>
                            </li>
                            <li>
                                <Link href="/person" className="hover:underline">Pessoas</Link>
                            </li>
                            <li>
                                <Link href="/account" className="hover:underline">Contas</Link>
                            </li>
                            <li>
                                <Link href="/movement" className="hover:underline">Movimentações</Link>
                            </li>
                        </ul>
                    </nav>
                </div>
            </header>
            <main className="max-w-5xl min-h-[91.2vh] mt-8 px-10 py-5 mx-auto">{children}</main>
            <footer className="bg-blue-500 p-4 text-white text-center mt-auto">
                <p>© 2024 , developed by: Aelcio Jozias</p>
            </footer>
        </div>
        </body>
        </html>
    );
}
