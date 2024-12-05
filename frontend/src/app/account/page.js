'use client';

import React, {useState} from 'react';
import {Button, Form, Input, Popconfirm, Space, Table} from 'antd';
import {DeleteOutlined, EditOutlined} from '@ant-design/icons';

const AccountForm = () => {
    const [form] = Form.useForm();
    const [accounts, setAccounts] = useState([
        {key: '1', name: 'Fulano da Silva', cpf: '000.111.222-33', accountNumber: '123456-1'},
        {key: '2', name: 'Cicrano do Souza', cpf: '111.111.111-11', accountNumber: '456789-2'},
        {key: '3', name: 'Beltrano Medeiros', cpf: '995.888.444-44', accountNumber: '789123-3'},
    ]);

    const onFinish = (values) => {
        const newAccount = {
            key: accounts.length + 1,
            name: values.name,
            cpf: values.cpf,
            accountNumber: values.accountNumber,
        };
        setAccounts([...accounts, newAccount]);
        form.resetFields();
    };

    const handleDelete = (key) => {
        setAccounts(accounts.filter(account => account.key !== key));
    };

    const handleEdit = (key) => {
        // Logic to handle editing the account
        console.log('Edit account with key: ', key);
    };

    const columns = [
        {
            title: 'Nome',
            dataIndex: 'name',
        },
        {
            title: 'CPF',
            dataIndex: 'cpf',
        },
        {
            title: 'Número da Conta',
            dataIndex: 'accountNumber',
        },
        {
            title: 'Ação',
            render: (_, record) => (
                <Space size="middle">
                    <Button
                        type="link"
                        icon={<EditOutlined/>}
                        onClick={() => handleEdit(record.key)}/>
                    <Popconfirm
                        title="Tem certeza que deseja excluir?"
                        onConfirm={() => handleDelete(record.key)}
                        okText="Sim"
                        cancelText="Não"
                    >
                        <Button type="link" icon={<DeleteOutlined/>}/>
                    </Popconfirm>
                </Space>
            ),
        },
    ];

    return (
        <div style={{padding: 20}}>
            <h3>Cadastro de Conta</h3>
            <Form form={form} onFinish={onFinish} layout="inline" style={{marginBottom: 20}}>
                <Form.Item
                    label="Nome"
                    name="name"
                    rules={[{required: true, message: 'Por favor, insira o nome!'}]}
                >
                    <Input placeholder="Nome completo"/>
                </Form.Item>
                <Form.Item
                    label="Número da Conta"
                    name="accountNumber"
                    rules={[{required: true, message: 'Por favor, insira o número da conta!'}]}
                >
                    <Input placeholder="Número da conta"/>
                </Form.Item>
                <Button type="primary" htmlType="submit">
                    Salvar
                </Button>
            </Form>
            <Table columns={columns} dataSource={accounts}/>
        </div>
    );
};

export default AccountForm;
